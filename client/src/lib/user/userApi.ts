import axios from "axios";

const API_URL = process.env.API_URL;

export async function getUserProfile(userIdToken: string | undefined) {
  try {
    if (!userIdToken) throw Error("no id token provided");

    const response = await axios.get(`${API_URL}/user/me`, {
      headers: {
        Authorization: `Bearer ${userIdToken}`,
      },
    });

    if (response.status !== 200) throw Error("no profile found");

    return response.data;
  } catch (error) {
    console.log("error getting userProfile", error);
    return false;
  }
}
