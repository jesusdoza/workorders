"use client";
import React from "react";
import { signOut } from "next-auth/react";
export default function Signout() {
  return (
    <div>
      <button onClick={() => signOut()}>Signout</button>
    </div>
  );
}
