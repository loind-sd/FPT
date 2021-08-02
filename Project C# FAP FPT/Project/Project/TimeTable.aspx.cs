using Project.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project
{
    public partial class TimeTable : System.Web.UI.Page
    {
        DAO dao = new DAO();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Session["student"] != null)
                {
                    Student s = (Student)Session["student"];
                    Label2.Text = "Hello " + s.Name;
                    Label1.Text = "Time Table for " + s.Name;

                    Calendar1.SelectedDate = DateTime.Now.Date;
                    GetTimeTable();
                }
                else
                {
                    Response.Redirect("Login.aspx");
                }

            }
        }

        private void GetTimeTable()
        {
            DateTime date = Calendar1.SelectedDate.Date;
            Student s = (Student)Session["student"];
            string id = s.ID;

            List<Time_Table> list = dao.GetTimeTable(date, id);

            if (list.Count == 0)
            {
                Label7.Visible = true;
            }
            else
            {
                Label7.Visible = false;
            }

            gvTimeTable.DataSource = list;
            gvTimeTable.DataBind();

            TextBox1.Text = String.Format("{0:d}", date);


            Session["Time_Table"] = list;

            for (int i = 0; i < list.Count; i++)
            {
                if (list[i].Status == 0)
                {
                    gvTimeTable.Rows[i].Cells[gvTimeTable.Rows[i].Cells.Count - 1].Text = "Not yet";
                    gvTimeTable.Rows[i].Cells[gvTimeTable.Rows[i].Cells.Count - 1].ForeColor = System.Drawing.Color.Red;
                }
                else if (list[i].Status == -1)
                {
                    gvTimeTable.Rows[i].Cells[gvTimeTable.Rows[i].Cells.Count - 1].Text = "Absent";
                    gvTimeTable.Rows[i].Cells[gvTimeTable.Rows[i].Cells.Count - 1].ForeColor = System.Drawing.Color.Red;
                }
                else
                {
                    gvTimeTable.Rows[i].Cells[gvTimeTable.Rows[i].Cells.Count - 1].Text = "Attended";
                    gvTimeTable.Rows[i].Cells[gvTimeTable.Rows[i].Cells.Count - 1].ForeColor = System.Drawing.Color.Green;
                }
            }

        }

        protected void Calendar1_SelectionChanged(object sender, EventArgs e)
        {
            GetTimeTable();
            Button1_Click(this, null);
        }

        //protected void Button1_Click(object sender, EventArgs e)
        //{
        //    int i = gvTimeTable.SelectedRow.RowIndex;
        //    List<Time_Table> list = (List<Time_Table>)Session["Time_Table"];
        //    string classID = list[i].ClassID;
        //    Response.Redirect("ViewClass.aspx");
        //}

        protected void gvTimeTable_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "View")
            {
                int index = Convert.ToInt32(e.CommandArgument);
                List<Time_Table> list = (List<Time_Table>)Session["Time_Table"];
                string classID = list[index].ClassID;
                Response.Redirect("ViewClass.aspx?class=" + classID);
            }
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            Response.Redirect("Logout.aspx");
        }

        protected void LinkButton2_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if (Button1.Text.Equals("Show Calendar"))
            {
                Calendar1.Visible = true;
                Button1.Text = "Hide Calendar";
            }
            else
            {
                Calendar1.Visible = false;
                Button1.Text = "Show Calendar";
            }
        }
    }
}