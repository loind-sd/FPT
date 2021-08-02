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
    public partial class UpPic : System.Web.UI.Page
    {
        private const string connectionString = "server=localhost; database=FAP_FPT; uid=sa; pwd=mothernumber1@;";
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string id = TextBox1.Text;

            string contentType = file.PostedFile.ContentType;
            System.IO.Stream stream = file.PostedFile.InputStream;

            byte[] buffer = new byte[stream.Length];
            stream.Read(buffer, 0, (int)stream.Length);

            using (SqlConnection cn = new SqlConnection(connectionString))
            {
                cn.Open();

                SqlCommand cm = new SqlCommand();
                cm.Connection = cn;
                cm.CommandText = "UPDATE dbo.Student SET Image = @Data WHERE StudentID = @id ";
                cm.CommandType = CommandType.Text;

                cm.Parameters.Add("@Data", SqlDbType.Image).Value = buffer;
                cm.Parameters.Add("@id", SqlDbType.VarChar).Value = id;

                cm.ExecuteNonQuery();

                cn.Close();
            }
        }

        protected void CheckBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (CheckBox1.Checked)
            {
                Label1.Visible = false;
            }
            else
            {
                Label1.Visible = true;
            }
        }

        protected void TextBox2_TextChanged(object sender, EventArgs e)
        {
            if (TextBox2.Text.StartsWith("0"))
            {
                TextBox2.Text = "alo";
            }
            else
            {
                TextBox2.Text = "alo2";
            }
        }
    }
}