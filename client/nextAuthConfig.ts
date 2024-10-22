import { AuthOptions } from "next-auth";
import GoogleProvider from "next-auth/providers/google";

export const authOptions: AuthOptions = {
  secret: process.env.NEXTAUTH_SECRET,
  // debug: true,
  callbacks: {
    async session({ session, token, user }) {
      // console.log("session callback", session);

      return { userId: token.sub, ...session };
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

        return { id: sub, name: given_name, image: picture, email };
      },
    }),
  ],
};
