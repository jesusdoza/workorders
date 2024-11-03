"use server";

type User = { name: string; email: string; username: string; id: string };
type UserProfile = User & { organizationId?: string };

export async function createUserProfile({
  user,
}: {
  user: User;
  authProvider: string;
  authServerId: string;
}) {
  console.log("user createed", user);
}

export async function getUserProfile(id: string) {
  return {
    name: "adf",
    email: "asfdasdf",
    id: "safefase",
    organizationId: "dsafadsf",
    username: "username",
  } as UserProfile;
}
export async function getUserProfileByAuthId(authId: string) {
  console.log("get user by auth id", authId);
  return {
    name: "adf",
    email: "asfdasdf",
    id: "safefase",
    organizationId: "dsafadsf",
    username: "username",
  } satisfies UserProfile;
}
