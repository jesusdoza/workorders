"use client";
import React from "react";

import { signIn } from "next-auth/react";
export default function SignInButton() {
  return (
    <div>
      <button onClick={() => signIn("google")}>Signin</button>
    </div>
  );
}
