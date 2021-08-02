<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ViewStudentInClass.aspx.cs" Inherits="Project.ViewStudentInClass" %>

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
            <asp:Label ID="Label5" runat="server" Text="Label"> | </asp:Label>
            <asp:LinkButton ID="LinkButton1" runat="server" OnClick="LinkButton1_Click">Logout</asp:LinkButton>
        </div>
        <div class="viewStudentInClass">
            <asp:Label ID="Label1" runat="server" Text="Another Class  "></asp:Label>
            <asp:DropDownList ID="ddlClass" runat="server" AutoPostBack="true" OnSelectedIndexChanged="ddlClass_SelectedIndexChanged">
            </asp:DropDownList>

            <br />


            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" CellPadding="4" EnableModelValidation="True" ForeColor="#333333" GridLines="None">
                <AlternatingRowStyle BackColor="White" />
                <Columns>
                    <asp:BoundField HeaderText="ID" DataField="ID" />
                    <asp:BoundField DataField="Name" HeaderText="Name"></asp:BoundField>
                </Columns>
                
                <EditRowStyle BackColor="#2461BF" />
                <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
                <RowStyle BackColor="#EFF3FB" />
                <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />
            </asp:GridView>


        </div>
    </form>
</body>
</html>
