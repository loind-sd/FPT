using Project.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project
{
    public partial class ViewStudentInClass : System.Web.UI.Page
    {
        string classId = string.Empty;
        string subject = string.Empty;
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
            if (!IsPostBack)
            {
                classId = Request.QueryString["class"];
                subject = Request.QueryString["subject"];
                LoadStudent();
                LoadCBB();
            }
        }
        private void LoadStudent()
        {
            List<Student> list = dao.GetAllStudentInClass(classId);
            GridView1.DataSource = list;
            GridView1.DataBind();
        }
        private void LoadCBB()
        {
            ddlClass.DataSource = dao.GetAllClassBySubject(subject);
            ddlClass.DataTextField = "ClassName";
            ddlClass.DataValueField = "ClassID";
            ddlClass.SelectedValue = classId;
            ddlClass.DataBind();
        }

        protected void ddlClass_SelectedIndexChanged(object sender, EventArgs e)
        {
            string id = ddlClass.SelectedValue;
            List<Student> list = dao.GetAllStudentInClass(id);
            GridView1.DataSource = list;
            GridView1.DataBind();
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