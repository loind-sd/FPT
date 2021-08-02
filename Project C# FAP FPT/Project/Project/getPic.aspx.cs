using Project.DTO;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project
{
    public partial class getPic : System.Web.UI.Page
    {
        private const string connectionString = "server=localhost; database=te; uid=sa; pwd=mothernumber1@;";
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Page.IsPostBack) return;

            int id = int.Parse(Request.QueryString["ID"]);

            using (SqlConnection cn = new SqlConnection(connectionString))
            {
                cn.Open();

                string sql = "SELECT ContentType, Data FROM c WHERE ID = @ID";

                SqlCommand cm = new SqlCommand();
                cm.CommandType = CommandType.Text;
                cm.CommandText = sql;
                cm.Connection = cn;
                cm.Parameters.Add("@ID", SqlDbType.Int).Value = id;

                SqlDataReader dr = cm.ExecuteReader();

                if (dr.Read())
                {
                    //Response.ContentType = (string)dr["ContentType"];
                    byte[] b = (byte[])dr["Data"];
                    //Response.BinaryWrite(b);
                    var base64 = Convert.ToBase64String(b);
                    var imgSrc = String.Format("data:image/gif;base64,{0}", base64);
                    ImageButton1.ImageUrl = imgSrc;
                    if (!IsPostBack)
                    {
                        DAO dao = new DAO();
                        List<Attendance> list = dao.GetAllStudentInClassForIns("SE1427_E5", 5);
                        foreach (var item in list)
                        {
                            var i = String.Format("data:image/gif;base64,{0}", item.Image);
                            item.ImageUrl = i;
                        }
                        
                        GridView1.DataSource = list;
                        GridView1.DataBind();
                    }
                }

                cn.Close();

                CheckBox1.CheckedChanged += CheckBox1_CheckedChanged;

            }
        }

        private void CheckBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (CheckBox1.Checked)
            {
                Label1.Text = "ngu";
            }
            else
            {
                Label1.Text = "ngu";
            }
        }

        protected void CheckBox1_CheckedChanged1(object sender, EventArgs e)
        {
            if(CheckBox1.Checked)
            {
                Label1.Text = "ngu";
            }
            else
            {
                Label1.Text = "ngu";
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Label1.Text = "alo";
        }
    }
}