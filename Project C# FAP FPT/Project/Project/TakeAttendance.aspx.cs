using Project.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project
{
    public partial class TakeAttendance : System.Web.UI.Page
    {
        DAO dao = new DAO();
        string classID = string.Empty;
        List<Attendance> list = new List<Attendance>();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["student"] == null && Session["instructor"] != null)
            {
                Instructor i = (Instructor)Session["instructor"];
                Label2.Text = "Hello " + i.Name;
            }
            else
            {
                Response.Redirect("Login.aspx");
            }

            classID = Request.QueryString["class"];
            int slot = Convert.ToInt32(Request.QueryString["slot"]);

            list = dao.GetAllStudentInClassForIns(classID, slot);

            int no = 1;
            foreach (var item in list)
            {
                TableRow tr = new TableRow();

                TableCell tcNo = new TableCell();
                tcNo.Text = no.ToString();

                TableCell tcStuID = new TableCell();
                tcStuID.Text = item.StudentID;

                TableCell tcStuName = new TableCell();
                tcStuName.Text = item.StudentName;

                TableCell tcStatus = new TableCell();
                //RadioButtonList rbl = new RadioButtonList();

                //ListItem listItem1 = new ListItem("Absent", "-1");
                //ListItem listItem2 = new ListItem("Attended", "1");
                //rbl.Items.Add(listItem1);
                //rbl.Items.Add(listItem2);
                //rbl.SelectedIndexChanged += Rbl_SelectedIndexChanged;
                //rbl.ToolTip = (no - 1).ToString();
                //rbl.SelectedIndex = 2;

                //tcStatus.Controls.Add(rbl);

                CheckBox cb = new CheckBox();
                cb.Text = "Attended";
                cb.ToolTip = (no - 1).ToString();
                cb.CheckedChanged += Cb_CheckedChanged;
                tcStatus.Controls.Add(cb);
                if (item.Status == 1)
                {
                    cb.Checked = true;
                }

                TableCell tcImage = new TableCell();
                ImageButton image = new ImageButton();
                image.Height = 100;
                image.Width = 100;
                byte[] b = item.Image;
                var base64 = Convert.ToBase64String(b);
                var imgSrc = String.Format("data:image/gif;base64,{0}", base64);
                image.ImageUrl = imgSrc;
                tcImage.Controls.Add(image);

                tr.Controls.Add(tcNo);
                tr.Controls.Add(tcStuID);
                tr.Controls.Add(tcStuName);
                tr.Controls.Add(tcStatus);
                tr.Controls.Add(tcImage);
                no++;

                Table1.Controls.Add(tr);
            }

        }

        private void Cb_CheckedChanged(object sender, EventArgs e)
        {
            int index = Convert.ToInt32((sender as CheckBox).ToolTip);
            if ((sender as CheckBox).Checked)
            {
                list[index].Status = 1;
            }
            else
            {
                list[index].Status = -1;
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            foreach (var item in list)
            {
                if (item.Status == 0)
                {
                    item.Status = -1;
                }
                dao.UpdateAttendance(item, classID, item.Slot);
            }
            Response.Redirect("ViewClassToday.aspx");
        }

        protected void LinkButton2_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            Response.Redirect("Logout.aspx");
        }

        

        protected void CheckBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (!CheckBox1.Checked)
            {
                for (int i = 1; i < Table1.Rows.Count; i++)
                {
                    Table1.Rows[i].Cells[Table1.Rows[i].Cells.Count - 1].Visible = false;
                }
            }
            else
            {
                for (int i = 1; i < Table1.Rows.Count; i++)
                {
                    Table1.Rows[i].Cells[Table1.Rows[i].Cells.Count - 1].Visible = true;
                }
            }
        }
    }
}
