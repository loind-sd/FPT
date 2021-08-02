using Project.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project
{
    public partial class ViewClassToday : System.Web.UI.Page
    {
        DAO dao = new DAO();
        List<Time_Table> list = new List<Time_Table>();
        protected void Page_Load(object sender, EventArgs e)
        {
            string id = string.Empty;
            if (Session["student"] == null && Session["instructor"] != null)
            {
                Instructor i = (Instructor)Session["instructor"];
                Label2.Text = "Hello " + i.Name;
                id = i.Id;
            }
            else
            {
                Response.Redirect("Login.aspx");
            }
            
            list = dao.GetAllClassForInstructor(id);
            if (list.Count == 0)
            {
                Label7.Visible = true;
            }
            if (!IsPostBack)
            {
                gvView.DataSource = list;
                gvView.DataBind();
            }
            
        }

        protected void gvView_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "Take")
            {
                int index = Convert.ToInt32(e.CommandArgument);
                string classID = list[index].ClassID;
                int slot = list[index].Slot;
                Response.Redirect("TakeAttendance.aspx?class=" + classID + "&slot=" + slot);
            }
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