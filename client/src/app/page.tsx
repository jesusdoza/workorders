import NavigationSidebar from "@/components/navigation/navigation-sidebar";
import React from "react";

export default function MainPage() {
  return (
    <div>
      <div className="hidden md:flex h-full w-[72px] z-30 flex-col fixed inset-y-0">
        <NavigationSidebar />
      </div>
    </div>
  );
}
