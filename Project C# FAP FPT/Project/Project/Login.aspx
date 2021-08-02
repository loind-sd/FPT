<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="Project.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link href="css/home.css" rel="stylesheet" />
</head>
<body>

    <form id="form1" runat="server">
            <div class="header">
                <asp:Label ID="Label4" runat="server" Text="FPT University Academy Portal" BackColor="Yellow" BorderColor="#CC3399" BorderStyle="Double" Font-Bold="True" Font-Size="XX-Large" ForeColor="#333300"></asp:Label>
            </div>
            <br />

            <fieldset style="width: 415px">
                <legend><span style="background-color: orange; color: white; font-weight: 600; font-size: 18px; padding: 4px; border-radius: 7px;"><b>Sinh viên, Giảng viên, Cán bộ ĐH-FPT</b></span></legend>
                <div class="login">
                    <br />
                    <div class="user">
                        <asp:Label ID="Label1" runat="server" Text="Username"></asp:Label>
                        <asp:TextBox ID="txtUser" runat="server"></asp:TextBox>
                    </div>
                    <div class="pass">
                        <asp:Label ID="Label2" runat="server" Text="Password"></asp:Label>
                        <asp:TextBox ID="txtPass" runat="server" TextMode="Password"></asp:TextBox>
                        <br />
                        <asp:CheckBox ID="CheckBox1" runat="server" Text="Instructor?" />
                    </div>
                    <div>
                        <asp:Button ID="Button1" runat="server" Text="Login" OnClick="Button1_Click" />
                    </div>
                    <asp:Label ID="Label3" runat="server" Text="Username or Password is not correct!" Visible="false" ForeColor="Red" Font-Size="Small"></asp:Label>
                </div>
            </fieldset>



    </form>
</body>
</html>
