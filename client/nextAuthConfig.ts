import { AuthOptions } from "next-auth";
import GoogleProvider from "next-auth/providers/google";

export const authOptions: AuthOptions = {
  secret: process.env.NEXTAUTH_SECRET,
  // debug: true,
  callbacks: {
    async session({ session, token }) {
      // console.log("session callback", session);
      // console.log("user session callback", user);
      // console.log("token session callback", token);

      return {
        userId: token.sub,
        ...session,
        idToken: token.idToken,
        authProvider: "google",
      };
    },
    async jwt({ token, account }) {
      // console.log("user jwt", user);
      // console.log("token jwt", token);
      // console.log("account jwt", account);
      // console.log("profile jwt", profile);
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
        // console.log("profile at google provider", profile);
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
