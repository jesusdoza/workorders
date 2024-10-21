"use server";
import { getServerSession } from "next-auth/next";
import { authOptions } from "../../[...nextauth]/route";

export default async function page() {
  const session = await getServerSession(authOptions);

  console.log("session", session);
  return <div>google callback</div>;
}
