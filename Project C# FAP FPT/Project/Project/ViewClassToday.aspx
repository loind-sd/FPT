<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ViewClassToday.aspx.cs" Inherits="Project.ViewClassToday" %>

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
        <div>
            <asp:Label ID="Label1" runat="server" Text="Take Attendance"></asp:Label>
        </div>
        <p style="color: red; font-size: 23px; background-color: antiquewhite; width: 435px;">
                        <asp:Label ID="Label7" runat="server" Text="Label" Visible="false">You have no classes today</asp:Label>
                    </p>
        <div class="viewClassToday">
            <asp:GridView ID="gvView" runat="server" AutoGenerateColumns="false" OnRowCommand="gvView_RowCommand">
                <Columns>
                    <asp:BoundField HeaderText="Slot" DataField="Slot" />
                </Columns>
                <Columns>
                    <asp:BoundField HeaderText="Class" DataField="ClassName" />
                </Columns>
                <Columns>
                    <asp:BoundField HeaderText="Subject" DataField="Subject" />
                </Columns>
                <Columns>
                    <asp:ButtonField ButtonType="Link" CommandName="Take" Text="Take" />
                </Columns>
            </asp:GridView>
        </div>
   
    </form>
</body>
</html>
