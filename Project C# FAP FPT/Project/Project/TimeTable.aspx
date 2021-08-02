<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="TimeTable.aspx.cs" Inherits="Project.TimeTable" %>

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
        <fieldset style="width: 615px; padding-top: 25px;">
            <legend><span style="background-color: orange; color: white; font-size: 18px; padding: 4px; border-radius: 7px;">Weekly Timetable</span></legend>

            <div class="timeTable">

                <div class="calendar">
                    <br />
                    <asp:Label ID="Label6" runat="server" Text="Choose Date   "></asp:Label>
                    <asp:TextBox ID="TextBox1" runat="server" Width="159px" ReadOnly="True"></asp:TextBox>
                    <span style="margin-left: 20px;">
                        <asp:Button ID="Button1" runat="server" Text="Show Calendar" Width="123px" OnClick="Button1_Click" /></span>

                    <br />
                    <div style="margin-top: 30px;">
                        <asp:Calendar Visible="false" ID="Calendar1" runat="server" BackColor="White" BorderColor="Black" DayNameFormat="Shortest" Font-Names="Times New Roman" Font-Size="10pt" ForeColor="Black" Height="220px" NextPrevFormat="FullMonth" TitleFormat="Month" Width="417px" OnSelectionChanged="Calendar1_SelectionChanged">
                            <DayHeaderStyle BackColor="#CCCCCC" Font-Bold="True" Font-Size="7pt" ForeColor="#333333" Height="10pt" />
                            <DayStyle Width="14%" />
                            <NextPrevStyle Font-Size="8pt" ForeColor="White" />
                            <OtherMonthDayStyle ForeColor="#999999" />
                            <SelectedDayStyle BackColor="#CC3333" ForeColor="White" />
                            <SelectorStyle BackColor="#CCCCCC" Font-Bold="True" Font-Names="Verdana" Font-Size="8pt" ForeColor="#333333" Width="1%" />
                            <TitleStyle BackColor="Black" Font-Bold="True" Font-Size="13pt" ForeColor="White" Height="14pt" />
                            <TodayDayStyle BackColor="#CCCC99" />

                        </asp:Calendar>
                    </div>


                </div>

                <div class="table">
                    <asp:Label ID="Label1" runat="server" Text="Label" Font-Bold="True"></asp:Label>

                    <p style="color: red; font-size: 23px; background-color: antiquewhite;">
                        <asp:Label ID="Label7" runat="server" Text="You have no activities in this day" Visible="False"></asp:Label>
                    </p>

                    <asp:GridView ID="gvTimeTable" runat="server" AutoGenerateColumns="false" OnRowCommand="gvTimeTable_RowCommand">
                        <Columns>
                            <asp:ButtonField HeaderText="Class" DataTextField="ClassName" CommandName="View" ButtonType="Link" />
                        </Columns>
                        <Columns>
                            <asp:BoundField HeaderText="Subject" DataField="Subject" />
                        </Columns>
                        <Columns>
                            <asp:BoundField HeaderText="Slot" DataField="Slot" />
                        </Columns>
                        <Columns>
                            <asp:BoundField HeaderText="Time" DataField="Time" />
                        </Columns>
                        <Columns>
                            <asp:BoundField HeaderText="Room" DataField="Room" />
                        </Columns>
                        <Columns>
                            <asp:BoundField HeaderText="Status" />
                        </Columns>
                    </asp:GridView>

                    <p>
                        <b>More note / Chú thích thêm</b>:
                    </p>
                    <div id="ctl00_mainContent_divfoot">
                        <ul>
                            <li>(<span style="color: green;">attended</span>): had attended this activity / đã tham gia hoạt động này</li>
                            <li>(<span style="color: red;">absent</span>): had NOT attended this activity / đã vắng mặt buổi này</li>
                            <li>(<span style="color: red;">Not yet</span>): no data was given / chưa có dữ liệu</li>
                        </ul>
                    </div>
                </div>

            </div>
        </fieldset>

    </form>
</body>
</html>
