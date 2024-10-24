import { AuthOptions } from "next-auth";
import GoogleProvider from "next-auth/providers/google";

export const authOptions: AuthOptions = {
  secret: process.env.NEXTAUTH_SECRET,
  debug: false,
  callbacks: {
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
