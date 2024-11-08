import { AuthOptions } from "next-auth";
import GoogleProvider from "next-auth/providers/google";
import { getUserProfile, createUserProfile } from "@/lib/user/userApi";

export const authOptions: AuthOptions = {
  secret: process.env.NEXTAUTH_SECRET,
  debug: false,
  callbacks: {
    // async signIn({ user, account, profile, credentials, email }) {
    async signIn({ account }) {
      try {
        const userIdToken = account?.id_token;
        let userProfile = await getUserProfile(userIdToken);

        if (!userProfile) {
          console.log("no user profile found");
          userProfile = await createUserProfile(userIdToken);
        }

        return true;
      } catch (error) {
        console.log("signin callback failed", String(error).slice(0, 10));
        return false;
      }
    },

    async redirect({ url }) {
      // async redirect({ url, baseUrl }) {
      //can compare where the redirect is going and take some action stops auth flow
      //TODO when error sign in show user reason
      return url;
    },
    async session({ session, token }) {
      return {
        userId: token.sub,
        ...session,
        idToken: token.idToken,
        authProvider: "google",
      };
    },
    async jwt({ token, account }) {
      return { idToken: account?.id_token, ...token };
    },
  },
  providers: [
    GoogleProvider({
      authorization: {
        params: { scope: "openid email profile" },
      },
      clientId: process.env.GOOGLE_CLIENT_ID as string,
      clientSecret: process.env.GOOGLE_CLIENT_SECRET as string,
      profile: (profile) => {
        const { email, sub, given_name, picture } = profile;

        return {
          id: sub,
          name: given_name,
          image: picture,
          email,
        };
      },
    }),
  ],
};
