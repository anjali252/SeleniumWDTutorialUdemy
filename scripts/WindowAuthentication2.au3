$title="Sign in"
WinWaitActive($title)
Sleep(4000)
Send("username")
Sleep(4000)
Send("{TAB}")
Send("password")
Sleep(4000)
Send("{ENTER}")