import axios, { AxiosError } from "axios";

const API_URL = process.env.API_URL;

// type UserProfile = {};

async function getUserProfile(userIdToken: string | undefined) {
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
    if (error instanceof AxiosError)
      console.log("error getting userProfile", error.status);
    return false;
  }
}

async function createUserProfile(userIdToken: string | undefined) {
  try {
    if (!userIdToken) throw Error("no id token provided");

    const response = await axios.post(
      `${API_URL}/user`,
      { mobileToken: "" },
      {
        headers: {
          Authorization: `Bearer ${userIdToken}`,
        },
      }
    );

    if (response.status !== 201) throw Error("failed to create profile");

    return response.data;
  } catch (error) {
    if (error instanceof AxiosError)
      console.log("error creating userProfile", error.status);
    return false;
  }
}

export { getUserProfile, createUserProfile };
