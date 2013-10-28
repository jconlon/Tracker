#!/usr/bin/perl
#########################################################
# DirectoryPass Version 1.1 by LockedArea.com		#
#                         http://www.lockedarea.com/   #
# Originally Released:    25th October 2001  (v1.0)	#
# Last Updated:		  13th November 2003 	  	#
#########################################################
#						  	#
# COPYRIGHT NOTE:					#
# DirectoryPass may be used and modified free of charge #
# by anyone so long as this copyright notice and the	#
# comments within remain intact. By using this code you #
# agree to indemnify Neil Skirrow and LockedArea.com 	#
# from any liability that might arise from its use.	#
# Selling the code for this program without prior  	#
# written consent is expressly forbidden. In other	#
# words, please ask first before you try and make money #
# off of our program. Obtain permission before 		#
# redistributing this software over the Internet or in  #
# any other medium.  In all cases copyright and header  #
# must remain intact.  We cannot be held responsible	#
# for any harm this may cause.			 	#
#							#
#########################################################
$adminpass = "fiord98";
# This is the only variable that needs changing, please #
# enter an administrators password for when using    	#
# DirectoryPass.					#
$htpassfile = "$ENV{'QUERY_STRING'}/.htpasswd";
$htfile = "$ENV{'QUERY_STRING'}/.htaccess";
#########################################################
use CGI qw(:standard);
$query = new CGI;
# Script begins
print "Content-type: text/html\n\n";
$adduser = $query->param('adduser');
&adduser if ($adduser && $ENV{'REQUEST_METHOD'} eq "POST");
$removeuser = $query->param('removeuser');
&removeuser if ($removeuser && $ENV{'REQUEST_METHOD'} eq "POST");
$create = $query->param('create');
&create if ($create && $ENV{'REQUEST_METHOD'} eq "POST");
&print_form if ($ENV{'REQUEST_METHOD'} eq "GET");

sub print_form {
$return = "$ENV{'SCRIPT_NAME'}?$ENV{'QUERY_STRING'}";
$usercount="0";
if ($ENV{'QUERY_STRING'}) {
open (FILE54, "$htpassfile");
@lines54 =<FILE54>;
close (FILE54);
foreach $line54 (@lines54) {
$usercount++;
}
&header;
print "<tr><td><font face=\"Arial\" size=\"1\">";
if ($usercount ne "0") {
print qq~
<font face="Arial" size="1">Currently $usercount users.<br>
~;
}
if (-e $htpassfile) {
print "$htpassfile already exists.<br>";
} else {
print "$htpassfile <font color=\"#ff0000\">does not exist.</font><br>";
}
if (-e $htfile) {
print "$htfile already exists.<br>";
} else {
print "$htfile <font color=\"#ff0000\">does not exist.</font><br>";
}
print qq~
</font>
<font face="Arial" size="2"><br><b><li> Add User</b><br><center>
<form action="$ENV{'SCRIPT_NAME'}" method="post"><input type="hidden" name="htfile" value="$htfile"><input type="hidden" name="return" value="$return">
<table width=360 cellpadding=1 cellspacing=0 border=0 bgcolor="f9f9f9">
<tr><td><font face="Arial" size="2"><b>Username:</b></font></td><td align=center><input type="text" name="username" size=20></td></tr>
<tr><td><font face="Arial" size="2"><b>Password:</b></font></td><td align=center><input type="password" name="password" size=20></td></tr>
<tr><td><font face="Arial" size="2"><b>Confirm Password:</b></font></td><td align=center><input type="password" name="confirmpassword" size=20></td></tr>
<tr><td><font face="Arial" size="2"><b>Admin Password:</b></font></td><td align=center><input type="password" name="actionpass" size=20></td></tr>
<tr><td><input type="hidden" name="passfile" value="$htpassfile"></td><td align=right><input type="submit" name="adduser" value="Add User"></td></tr></table></form></center>
<p><b><li> Remove User</b><br><center><form action="$ENV{'SCRIPT_NAME'}" method="post"><input type="hidden" name="htfile" value="$htfile"><input type="hidden" name="return" value="$return">
<table width=360 cellpadding=1 cellspacing=0 border=0 bgcolor="f9f9f9">
<tr><td><font face="Arial" size="2"><b>Username:</b></font></td><td align=center><select name=username>
~;
open (DATA, "$htpassfile");
@indata = <DATA>;
close (DATA);
@indata = sort (@indata);
foreach $entries (@indata){
($dbusername, $dbpassword) = split(/\:/, $entries);
print "<option value=\"$dbusername\">$dbusername</option>\n";
}
print qq~
</select></td></tr><tr><td><font face="Arial" size="2"><b>Admin Password:</b></font></td><td align=center><input type=password name=actionpass size=20></td></tr><tr><td><input type="hidden" name="passfile" value="$htpassfile"></td><td align=right><input type="submit" name="removeuser" value="Remove User"></td></tr>
</table></form></center><p>
<p><b><li> .htaccess Maintanence</b><br>
Clicking create below will create your .htaccess file in the directory that you've specified as the query string.  Do not do this if you have already got a .htaccess file there.<br>
<center><form action="$ENV{'SCRIPT_NAME'}" method="post"><input type="hidden" name="return" value="$return">
<table width=360 cellpadding=1 cellspacing=0 border=0 bgcolor="f9f9f9">
<tr><td><font face="Arial" size="2"><b>Member's Area Name</b></font></td><td align=center><input type="text" name="membersname" size=20></td></tr>
<tr><td><font face="Arial" size="2"><b>Admin Password</b></font></td><td align=center><input type="password" name="actionpass" size=20></td></tr>
<tr><td><font face="Arial" size="2"><b>Are you on a Cobalt RAQ server?</b></font></td><td align=center><input type="checkbox" name="cobalt" value="yes"> <font face="Arial" size=1>Tick for yes.</font></td></tr>
<tr><td><input type="hidden" name="htpassfile" value="$htpassfile"><input type="hidden" name="htaccfile" value="$htfile"></td><td align=right><input type="submit" name="create" value="Create"></td></tr></table></form></center>
<p><b><li>Rate DirectoryPass</b><br>
<a href="http://cgi.resourceindex.com/rate?07243" target=_new>Rate DirectoryPass @ The CGI Resource Index</a><br>
<a href="http://www.hotscripts.com/cgi-bin/rate.cgi?ID=12630" target=_new>Rate DirectoryPass @ HotScripts.com</a><br>
<a href="http://www.cgi-index.com/cgi-bin/rate.cgi?ID=492" target=_new>Rate DirectoryPass @ The CGI-Index.com</a><br>
</font>
~;
&footer;
exit;
} else {
&header;
print qq~
<tr><td><font face="Arial" size="1">
Script called incorrectly.  Please try again.<p>
Should be called something like:<br>
dirpass.cgi?/home/username/path/to/members/dir<br>
Basically after the ? you need to put the full/absolute server path to the directory you want to password protect or administrate.  A relative path or enviroment variable will not work.<br>
NO TRAILING SLASH PLEASE!<p>
For example, the path to this script file is:<br><b>$ENV{'SCRIPT_FILENAME'}</b>
</font></td></tr>
~;
&footer;
exit;
}
}

sub removeuser {
$username = $query->param('username');
$actionpass = $query->param('actionpass');
$passfile =  $query->param('passfile');
$htpassfile = $passfile;
$return = $query->param('return');
$htfile =  $query->param('htfile');
if ($actionpass eq $adminpass) {
	open (READHT, "$passfile") or &die_clean("Couldn't open file $passfile");
	@htpw = <READHT>;
	close (READHT);
	open (WRITEHT, ">$passfile");
	flock (WRITEHT,2);
	foreach $passline (@htpw) {
		($htdbuser, $htdbpass) = split(/\:/, $passline);
		if ($htdbuser eq $username) {
		} else {
			print WRITEHT $passline;
		}
	}
	flock (WRITEHT,8);
	close (WRITEHT);
&header;
print qq~
<tr><td><font face="Arial" size="2"><br><b><li>User Removed</b><p>
$username has been removed from the database.<p>
<a href="$return"><b>Return to main menu</b></a><br></font></td></tr>
~;
&footer;
exit;
} else {
&error;
}
}
sub create {
$cobalt = $query->param('cobalt');
$htaccfile =  $query->param('htaccfile');
$membersname =  $query->param('membersname');
$membersname =~ s/\"//g;

$htpassfile =  $query->param('htpassfile');
$actionpass = $query->param('actionpass');
$return = $query->param('return');
if ($actionpass eq $adminpass) {
if ($cobalt eq "yes") {
open (HTACCESS, ">>$htaccfile") or &die_clean("Couldn't create file $htaccfile");
print HTACCESS "AuthType Basic\n";
print HTACCESS "AuthName \"$membersname\"\n";
print HTACCESS "AuthUserFile $htpassfile\n";
print HTACCESS "require valid-user\n";
print HTACCESS "AuthPAM_Enabled off\n";
flock (HTACCESS, 8);
close (HTACCESS);
} else {
open (HTACCESS, ">>$htaccfile") or &die_clean("Couldn't create file $htaccfile");
print HTACCESS "AuthType Basic\n";
print HTACCESS "AuthName \"$membersname\"\n";
print HTACCESS "AuthUserFile $htpassfile\n";
print HTACCESS "require valid-user\n";
flock (HTACCESS, 8);
close (HTACCESS);
}
&header;
print qq~
<tr><td><font face="Arial" size="2"><br><b><li> .htaccess</b><p>
Your .htaccess file has been created.<p>
<a href="$return"><b>Return to main menu</b></a><br></font></td></tr>
~;
&footer;
exit;
} else {
&error;
}
}

sub adduser {
$return = $query->param('return');
$username = $query->param('username');
$password = $query->param('password');
$confirmpassword = $query->param('confirmpassword');
$actionpass = $query->param('actionpass');
$passfile =  $query->param('passfile');
$htpassfile = $passfile;
$htfile =  $query->param('htfile');
&error if ($actionpass ne $adminpass);
$passwordok = $password if (($password eq $confirmpassword) && (length($password) > 4));
$usernameok = $username if (length($username) > 4);
unless ($usernameok && $passwordok) {
&header;
print qq~
<tr><td><font face="Arial" size="2"><br><b><li> Add User Error</b><p>
~;
	print "<li>You didn't enter a username or it was less than 5 characters in length.<br>" unless ($usernameok);
	print "" unless ($usernameok && $passwordok);
	print "<li>You didn't enter a password or confirm password, they didn't match or they were less than 5 characters in length.<br>" unless ($passwordok);
	print qq~
<br><center>
<form action="$ENV{'SCRIPT_NAME'}" method="post"><input type="hidden" name="htfile" value="$htfile"><table width=300 cellpadding=1 cellspacing=0 border=0 bgcolor="f9f9f9">
<tr><td><font face="Arial" size="2"><b>Username:</b></font></td><td align=center><input type=text name=username value="$usernameok" size=20></td></tr>
<tr><td><font face="Arial" size="2"><b>Password:</b></font></td><td align=center><input type=password name=password size=20></td></tr>
<tr><td><font face="Arial" size="2"><b>Confirm Password:</b></font></td><td align=center><input type=password name=confirmpassword size=20></td></tr>
<tr><td><font face="Arial" size="2"><b>Admin Password:</b></font></td><td align=center><input type=password name=actionpass size=20></td></tr>
<tr><td></td><td align=right><input type=submit name=adduser value="Add User"></td></tr></table></form></center><p>
<a href="$return"><b>Return to main menu</b></a><br></font></td></tr>
~;
&footer;
	exit;
}
open (DATABASEA, "$passfile");
@wholebasea = <DATABASEA>;
close (DATABASEA);
foreach $oldusera (@wholebasea) {
	chomp ($olduser);
	@usera = split(/\:/, $oldusera);
	if ($usernameok eq $usera[0]) {
&header;
print qq~
<tr><td><font face="Arial" size="2"><br><b><li> Add User Error</b><p>
Username already taken!<p>
<a href="$return"><b>Return to main menu</b></a><br></font></td></tr>
~;
&footer;
		exit;
	}
	}
$usernameok =~ s/\://g;
$passwordok =~ s/\://g;
$enc_password = crypt($passwordok, "Cd");
open (DATABASEADD, ">>$passfile") or &die_clean("Couldn't open file $passfile");
flock (DATABASEADD, 2);
print DATABASEADD "$usernameok:$enc_password\n";
flock (DATABASEADD, 8);
close (DATABASEADD);
&header;
print qq~
<tr><td><font face="Arial" size="1">
$passfile<br>$htfile</font><font face="Arial" size="2"><br><b><li> Add User Complete</b><p>
User Added:<br>
Username: $usernameok<br>
Password: $passwordok<br>
Encrypted Password: $enc_password<p>
<a href="$return"><b>Return to main menu</b></a><br></font></td></tr>
~;
&footer;
exit;
}
sub error {
&header;
print qq~
<tr><td><font face="Arial" size="2"><br><b><li> Password Error</b><p>
Your administration password is incorrect.<p>
<a href="$return"><b>Return to main menu</b></a><br></font></td></tr>
~;
&footer;
exit;
}
sub header {
print qq~
<html><head><title>LockedArea.com: DirectoryPass</title></head>
<body bgcolor="#dedede" text="#000000" link="#000080" vlink="#000080">
<table width=100% height=100% cellpadding=0 cellspacing=0 border=0>
<tr><td align=center valign=middle><table width=400 cellpadding=4 cellspacing=0 border=0 bgcolor=#f1f1f1>
<tr><td bgcolor=#CCCCCC><font face="Arial" size="2"><b><a href="http://www.lockedarea.com/" target=_new>LockedArea.com</a>: DirectoryPass</b></font></td></tr>
~;
}
sub footer {
print qq~
<tr><td align=right><font face="Arial" size="1">&nbsp;<br>Powered by <a href="http://www.locked-area.com/html/dp/" target=_new>DirectoryPass</a> v1.1.  A product of
<a href="http://www.lockedarea.com/" target=_new>LockedArea.com</a>.<br>&copy; Copyright 2001-03 Neil Skirrow and LockedArea.com.  All Rights Reserved.</td></tr></table><p>&nbsp;<p>&nbsp;</td></tr></table>
</body></html>
~;
}
sub die_clean {
    ($errmsg) = @_;
    &header;
print qq~
<tr><td><font face="Arial" size="2"><br><b><li> DirectoryPass System Error</b><p>
$errmsg<p>
<a href="$return"><b>Return to main menu</b></a><br></font></td></tr>
~;
&footer;
    exit;
}