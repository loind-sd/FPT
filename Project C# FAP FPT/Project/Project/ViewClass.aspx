<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ViewClass.aspx.cs" Inherits="Project.ViewClass" %>

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
        <div class="linkHeader">
            <asp:Label ID="Label2" runat="server"></asp:Label>
            <asp:Label ID="Label3" runat="server" Text="|"></asp:Label>
            <asp:LinkButton ID="LinkButton2" runat="server" OnClick="LinkButton2_Click">Home</asp:LinkButton>
            <asp:Label ID="Label5" runat="server" Text="Label">  | </asp:Label>
            <asp:LinkButton ID="LinkButton1" runat="server" OnClick="LinkButton1_Click">Logout</asp:LinkButton>
        </div>
        <div class="viewClass">

            <asp:Table ID="Table1" runat="server" BorderStyle="Double" Width="376px">
                <asp:TableRow>
                    <asp:TableCell>
                        Subject Code
                    </asp:TableCell>
                    <asp:TableCell>
                        <asp:Label ID="lbCode" runat="server" Text="Label"></asp:Label>
                    </asp:TableCell>
                </asp:TableRow>
                <asp:TableRow>
                    <asp:TableCell>
                        Subject Name
                    </asp:TableCell>
                    <asp:TableCell>
                        <asp:Label ID="lbName" runat="server" Text="Label"></asp:Label>
                    </asp:TableCell>
                </asp:TableRow>
                <asp:TableRow>
                    <asp:TableCell>
                        Class
                    </asp:TableCell>
                    <asp:TableCell>
                        <asp:LinkButton ID="lbClass" runat="server">LinkButton</asp:LinkButton>
                    </asp:TableCell>
                </asp:TableRow>
                <asp:TableRow>
                    <asp:TableCell>
                        Instructor
                    </asp:TableCell>
                    <asp:TableCell>
                        <asp:Label ID="lbInstructor" runat="server" Text="Label"></asp:Label>
                    </asp:TableCell>
                </asp:TableRow>
            </asp:Table>
        </div>
    </form>
</body>
</html>
