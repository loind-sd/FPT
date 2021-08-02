using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Project.DTO
{
    public class Attendance
    {
        public string StudentID { get; set; }
        public string StudentName { get; set; }
        public int Status { get; set; }

        public int Slot { get; set; }
        public byte[] Image { get; set; }
        public string ImageUrl { get; set; }

        public Attendance(string studentID, string studentName, int status, int slot)
        {
            StudentID = studentID;
            StudentName = studentName;
            Status = status;
            Slot = slot;
        }

        public Attendance(string studentID, string studentName, int status, int slot, byte[] image) : this(studentID, studentName, status, slot)
        {
            Image = image;
        }
    }
}