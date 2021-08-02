using Project.DTO;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Label3.Visible = false;
            if (Session["student"] != null || Session["instructor"] != null)
            {
                Response.Redirect("Logout.aspx");
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            DAO dao = new DAO();
            if (!CheckBox1.Checked)
            {
                Student s = dao.StudentLogin(txtUser.Text, txtPass.Text);
                if (s == null)
                {
                    Label3.Visible = true;
                }
                else
                {
                    Session["student"] = s;
                    Response.Redirect("Home.aspx");
                }
            } else
            {
                Instructor instructor = dao.InstructorLogin(txtUser.Text, txtPass.Text);
                if (instructor == null)
                {
                    Label3.Visible = true;
                }
                else
                {
                    Session["instructor"] = instructor;
                    Response.Redirect("Home.aspx");
                }
            }
        }
    }
}