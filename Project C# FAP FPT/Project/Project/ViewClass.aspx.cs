using Project.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project
{
    public partial class ViewClass : System.Web.UI.Page
    {
        string classId = string.Empty;
        DAO dao = new DAO();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["student"] != null)
            {
                Student s = (Student)Session["student"];
                Label2.Text = "Hello " + s.Name;
            }
            else
            {
                Response.Redirect("Login.aspx");
            }

            classId = Request.QueryString["class"];
            Class c = dao.GetClassByID(classId);
            lbCode.Text = c.SubjectCode;
            lbName.Text = c.SubjectName;
            lbClass.Text = c.ClassName;
            lbInstructor.Text = c.Instructor;

            lbClass.Click += LbClass_Click;

        }

        private void LbClass_Click(object sender, EventArgs e)
        {
            Response.Redirect("ViewStudentInClass.aspx?class=" + classId + "&subject=" + lbCode.Text);
        }

        protected void LinkButton2_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            Response.Redirect("Logout.aspx");
        }
    }
}