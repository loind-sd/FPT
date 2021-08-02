using Project.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project
{
    public partial class Home : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["student"] != null && Session["instructor"] == null)
            {
                Student s = (Student)Session["student"];
                Label1.Text = "Hello " + s.Name;
                LinkButton2.Visible = true;
                LinkButton3.Visible = false;
            }
            else if (Session["student"] == null && Session["instructor"] != null)
            {
                Instructor i = (Instructor)Session["instructor"];
                Label1.Text = "Hello " + i.Name;
                LinkButton2.Visible = false;
                LinkButton3.Visible = true;
            }
            else
            {
                Response.Redirect("Login.aspx");
            }
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            Response.Redirect("Logout.aspx");
        }

        protected void LinkButton2_Click(object sender, EventArgs e)
        {
            Response.Redirect("TimeTable.aspx");
        }

        protected void LinkButton3_Click(object sender, EventArgs e)
        {
            Response.Redirect("ViewClassToday.aspx");
        }
    }
}