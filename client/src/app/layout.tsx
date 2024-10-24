import "./globals.css";
import type { Metadata } from "next";
import { Open_Sans } from "next/font/google";
import Signout from "@/components/ui/auth/SignoutButton";

import { cn } from "@/lib/utils";
// import { ModalProvider } from "@/components/providers/modal-provider";
// import { ClerkProvider, RedirectToSignIn } from "@clerk/nextjs";
// import { ThemeProvider } from "@/components/providers/theme-provider";

const font = Open_Sans({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "Work Orders",
  description: "workorder database",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    // <ClerkProvider
    //   signInUrl="/sign-in"
    //   signUpUrl="/sign-up">
    <html
      lang="en"
      suppressHydrationWarning>
      <body className={cn(font.className, "bg-white dark:bg-[#313338]")}>
        {children}
      </body>
    </html>
  );
}
