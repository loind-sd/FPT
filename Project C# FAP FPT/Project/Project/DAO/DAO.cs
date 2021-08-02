using Access;
using Project.DTO;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace Project
{
    public class DAO
    {
        public DataTable Login(string user, string pass, int type)
        {
            string select = "select * from Instructor where username = @u and password = @p ";
            if (type == 1) // student
            {
                select = "select * from Student where username = @u and password = @p ";
            }
            return DataProvider.Instance.ExecuteQuery(select, new object[] { user, pass });
        }

        public Student StudentLogin(string user, string pass)
        {
            DataTable dt = Login(user, pass, 1);
            Student s = null;
            foreach (DataRow dr in dt.Rows)
            {
                s = new Student(
                    dr["StudentID"].ToString(),
                    dr["studentName"].ToString(),
                    Convert.ToDateTime(dr["DOB"].ToString()),
                    Convert.ToBoolean(dr["Gender"].ToString()),
                    dr["Address"].ToString());
            }
            return s;
        }

        public Instructor InstructorLogin(string user, string pass)
        {
            DataTable dt = Login(user, pass, 0);
            if (dt.Rows.Count > 0)
            {
                DataRow dr = dt.Rows[0];
                return new Instructor(dr["InstructorID"].ToString(), dr["InstructorName"].ToString());
            }
            return null;
        }

        public List<Time_Table> GetTimeTable(DateTime d, string studentid)
        {
            List<Time_Table> list = new List<Time_Table>();
            string sql = @"SELECT a.ClassID, c.ClassName, c.SubjectID, ti.*, a.Date, a.Room, a.Status
                        FROM dbo.Attendance a 
                        JOIN dbo.Time ti ON ti.Slot = a.Slot
                        JOIN dbo.Class c ON c.ClassID = a.ClassID
                        WHERE a.Date = @d AND a.StudentID = @id ";
            DataTable dt = DataProvider.Instance.ExecuteQuery(sql, new object[] { d, studentid });
            foreach (DataRow dataRow in dt.Rows)
            {
                list.Add(new Time_Table(
                    dataRow["ClassID"].ToString(),
                    dataRow["ClassName"].ToString(),
                    dataRow["SubjectID"].ToString(),
                    Convert.ToInt32(dataRow["Slot"].ToString()),
                    dataRow["Time"].ToString(),
                    Convert.ToDateTime(dataRow["Date"].ToString()),
                    dataRow["Room"].ToString(),
                    Convert.ToInt32(dataRow["Status"].ToString())));
            }
            return list;
        }

        public Class GetClassByID(string id)
        {
            string sql = @"SELECT c.ClassID, c.ClassName, c.SubjectID, s.SubjectName, i.InstructorName 
                        FROM dbo.Class c
                        JOIN dbo.Instructor i ON i.InstructorID = c.InstructorID
                        JOIN dbo.Subject s ON s.SubjectID = c.SubjectID
                        WHERE c.ClassID = @id ";
            DataTable dt = DataProvider.Instance.ExecuteQuery(sql, new object[] { id });
            DataRow dr = dt.Rows[0];
            return new Class(
                dr["ClassID"].ToString(),
                dr["ClassName"].ToString(),
                dr["SubjectID"].ToString(),
                dr["SubjectName"].ToString(),
                dr["InstructorName"].ToString());
        }

        public List<Student> GetAllStudentInClass(string id)
        {
            List<Student> list = new List<Student>();
            string sql = @"SELECT g.StudentID, s.StudentName
                        FROM dbo.Class c 
                        JOIN dbo.Grade g ON g.ClassID = c.ClassID
                        JOIN dbo.Student s ON s.StudentID = g.StudentID
                        WHERE g.ClassID = @id 
                        ORDER BY s.StudentID";
            DataTable dt = DataProvider.Instance.ExecuteQuery(sql, new object[] { id });
            foreach (DataRow data in dt.Rows)
            {
                list.Add(new Student(data["StudentID"].ToString(), data["StudentName"].ToString()));
            }
            return list;
        }

        public List<Class> GetAllClassBySubject(string code)
        {
            List<Class> list = new List<Class>();
            string sql = @"SELECT c.* FROM dbo.Class c 
                        JOIN dbo.Subject s ON s.SubjectID = c.SubjectID
                        WHERE s.SubjectID = @code ";
            DataTable dt = DataProvider.Instance.ExecuteQuery(sql, new object[] { code });
            foreach (DataRow data in dt.Rows)
            {
                list.Add(new Class(data["ClassID"].ToString(), data["ClassName"].ToString()));
            }
            return list;
        }

        public List<Time_Table> GetAllClassForInstructor(string id)
        {
            List<Time_Table> list = new List<Time_Table>();
            string sql = @"SELECT c.ClassID, c.ClassName, s.SubjectName, tt.Slot
                        FROM dbo.Class c 
                        JOIN dbo.Subject s ON s.SubjectID = c.SubjectID
                        JOIN dbo.Time_Table tt ON tt.ClassID = c.ClassID
                        WHERE tt.Date = CAST(GETDATE() AS DATE) AND c.InstructorID = @id 
                        ORDER BY tt.Slot";
            DataTable dt = DataProvider.Instance.ExecuteQuery(sql, new object[] { id });
            foreach (DataRow data in dt.Rows)
            {
                list.Add(new Time_Table(data["ClassID"].ToString(), data["ClassName"].ToString(), data["SubjectName"].ToString(), Convert.ToInt32(data["Slot"].ToString())));
            }
            return list;
        }

        public List<Attendance> GetAllStudentInClassForIns(string id, int slot)
        {
            List<Attendance> list = new List<Attendance>();
            string sql = @"SELECT s.StudentID, s.StudentName, a.Status, a.Slot, s.Image 
                        FROM dbo.Attendance a 
                        JOIN dbo.Student s ON s.StudentID = a.StudentID
                        WHERE a.ClassID = @id AND a.Date = CAST(GETDATE() AS DATE) AND a.Slot = @slot ";
            DataTable dt = DataProvider.Instance.ExecuteQuery(sql, new object[] { id, slot });
            foreach (DataRow data in dt.Rows)
            {
                list.Add(new Attendance(
                    data["StudentID"].ToString(),
                    data["StudentName"].ToString(),
                    Convert.ToInt32(data["Status"].ToString()),
                    Convert.ToInt32(data["Slot"].ToString()),
                    (byte[])data["Image"]));
            }
            return list;
        }

        public void UpdateAttendance(Attendance a, string id, int slot)
        {
            string sql = @"UPDATE dbo.Attendance SET Status = @status  
                        WHERE Date = CAST(GETDATE() AS DATE) AND StudentID = @stuid 
                        AND ClassID = @id AND Slot = @slot ";
            DataProvider.Instance.ExecuteNonQuery(sql, new object[] { a.Status, a.StudentID, id, slot });
        }
    }
}