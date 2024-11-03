import NavigationSidebar from "@/components/navigation/navigation-sidebar";
import { getServerSession } from "next-auth";
import React from "react";
import { authOptions } from "../../nextAuthConfig";

export default async function MainPage() {
  const session = await getServerSession(authOptions);

  // console.log("session in page server component", session);
  return (
    <div>
      <div className="hidden md:flex h-full w-[72px] z-30 flex-col fixed inset-y-0">
        <NavigationSidebar />
      </div>
    </div>
  );
}
