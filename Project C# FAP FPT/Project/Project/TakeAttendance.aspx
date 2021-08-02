<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="TakeAttendance.aspx.cs" Inherits="Project.TakeAttendance" %>

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
        <div style="margin-left: 20px">
            <asp:Label ID="Label1" runat="server" Text="Take Attendance"></asp:Label>
            <br />
            <br />
        </div>

        <div class="takeAttendance" style="margin-left: 20px">
            <asp:Table ID="Table1" runat="server">
                <asp:TableHeaderRow>
                    <asp:TableHeaderCell>No</asp:TableHeaderCell>
                    <asp:TableHeaderCell>Student ID</asp:TableHeaderCell>
                    <asp:TableHeaderCell>Student Name</asp:TableHeaderCell>
                    <asp:TableHeaderCell>Status</asp:TableHeaderCell>
                    <asp:TableHeaderCell>
                        <asp:CheckBox ID="CheckBox1" runat="server" Text="ShowImage" Checked="true" AutoPostBack="true" OnCheckedChanged="CheckBox1_CheckedChanged" />
                    </asp:TableHeaderCell>
                </asp:TableHeaderRow>
            </asp:Table>
            <br />
            <br />
                <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="ADD" />
        </div>
    </form>
</body>
</html>
