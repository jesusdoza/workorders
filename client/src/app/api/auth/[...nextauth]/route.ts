import NextAuth from "next-auth";
import GoogleProvider from "next-auth/providers/google";

const handler = NextAuth({
  debug: true,
  providers: [
    GoogleProvider({
      clientId: process.env.GOOGLE_CLIENT_ID as string,
      clientSecret: process.env.GOOGLE_CLIENT_SECRET as string,
      profile(profile) {
        const { email, sub, given_name, picture } = profile;
        return { id: sub, name: given_name, image: picture, email };
      },
    }),
  ],
});

export { handler as GET, handler as POST };
