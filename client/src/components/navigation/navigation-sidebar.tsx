// import currentProfile from "@/lib/current-profile";
// import { db } from "@/lib/db";

import { getUserProfile } from "@/hooks/useApi";
import { redirect } from "next/navigation";
import React from "react";
import NavigationAction from "@/components/navigation/navigation-action";
import { Separator } from "@/components/ui/separator";
import { ScrollArea } from "@/components/ui/scroll-area";
import { NavigationItem } from "@/components/navigation/navigation-item";
import { ModeToggle } from "@/components/mode-toggle";
// import { UserButton } from "@clerk/nextjs";
import imagePlaceHolder from "../../app/favicon.ico";

const NavigationSidebar = async () => {
  const profile = await getUserProfile();

  if (!profile) return redirect("/");

  const navLinks = [
    { id: "idLink", name: "name of link", imageUrl: imagePlaceHolder },
  ];

  return (
    <div className="space-y-4 flex flex-col items-center h-full text-primary w-full dark:bg-[#1E1F22] py-3">
      <NavigationAction />
      <Separator className="h-[2px] bg-zinc-300 dark:bg-zinc-700 rounded-md w-10 mx-auto" />
      <ScrollArea className="flex-1 w-full">
        {navLinks.map((links) => {
          return (
            <div
              key={links.id}
              className="mb-4 ">
              <NavigationItem
                id={links.id}
                name={links.name}
                imageUrl={links.imageUrl}
              />
            </div>
          );
        })}
      </ScrollArea>
      <div className="pb-3 mt-auto items-center flex flex-col gap-y-4">
        <ModeToggle />
        {/* <UserButton
          afterSignOutUrl="/"
          appearance={{
            elements: {
              avatarBox: "h-[48px] w-[48px]",
            },
          }}></UserButton> */}
      </div>
    </div>
  );
};

export default NavigationSidebar;
