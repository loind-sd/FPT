<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="getPic.aspx.cs" Inherits="Project.getPic" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Image ID="Image1" runat="server" />
        </div>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="200px" Width="200px" />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="false">
            <Columns>
                <asp:ImageField DataImageUrlField="Image" NullDisplayText="AloNull" AlternateText="alo">
                </asp:ImageField>
            </Columns>
            <Columns>
                <asp:BoundField DataField="Slot" />
                
            </Columns>
            <Columns>
                <asp:BoundField DataField="ImageUrl" />
            </Columns>
        </asp:GridView>
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        <br />
        <asp:CheckBox ID="CheckBox1" runat="server" OnCheckedChanged="CheckBox1_CheckedChanged1" />
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Button" />
    </form>
</body>
</html>
