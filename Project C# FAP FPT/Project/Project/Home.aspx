<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="Project.Home" %>

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
            <asp:Label ID="Label1" runat="server"></asp:Label>
            <asp:Label ID="Label2" runat="server" Text="|"></asp:Label>
            <asp:LinkButton ID="LinkButton1" runat="server" OnClick="LinkButton1_Click">Logout</asp:LinkButton>
        </div>

        <fieldset style="width: 415px;     padding-top: 25px;">
            <legend><span style="background-color: orange; color: white; font-size: 18px; padding: 4px; border-radius: 7px;">Academy Information</span></legend>

        
        <div style="margin-left: 20px;">
            <asp:LinkButton ID="LinkButton2" runat="server" OnClick="LinkButton2_Click">View Time Table</asp:LinkButton>
        </div>
        <div style="margin-left: 20px;">
            <asp:LinkButton ID="LinkButton3" runat="server" OnClick="LinkButton3_Click">Take Attendence</asp:LinkButton>
        </div>

            </fieldset>

    </form>
</body>
</html>
