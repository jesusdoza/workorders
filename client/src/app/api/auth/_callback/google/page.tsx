"use server";
import { getServerSession } from "next-auth/next";
import { authOptions } from "../../../../../../nextAuthConfig";

export default async function page() {
  const session = await getServerSession(authOptions);

  console.log("session", session);
  return (
    <div>
      <div>google callback</div>
    </div>
  );
}
