// import { auth } from "@clerk/nextjs";
// import { db } from "./db";

import { getUserProfile } from "@/hooks/useApi";

function auth() {
  return { userId: "user id" };
}

const currentProfile = async () => {
  const { userId } = auth();

  if (!userId) return null;

  const profile = await getUserProfile();
  return profile;
};

export default currentProfile;
