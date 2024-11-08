"use server";

type User = { name: string; email: string; username: string; id: string };
type UserProfile = User & { organizationId?: string };

async function getUserProfileByAuthId(authId: string) {
  console.log("get user by auth id", authId);
  return {
    name: "adf",
    email: "asfdasdf",
    id: "safefase",
    organizationId: "dsafadsf",
    username: "username",
  } satisfies UserProfile;
}

export { getUserProfileByAuthId };
