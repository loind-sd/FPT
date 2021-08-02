using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Project.DTO
{
    public class Time_Table
    {
        public string ClassID { get; set; }
        public string ClassName { get; set; }
        public string Subject { get; set; }
        public int Slot { get; set; }
        public string Time { get; set; }
        public DateTime Date { get; set; }
        public string Room { get; set; }
        public int Status { get; set; }

        public Time_Table(string classID, string className, string subject, int slot, string time, DateTime date, string room, int status)
        {
            ClassID = classID;
            ClassName = className;
            Subject = subject;
            Slot = slot;
            Time = time;
            Date = date;
            Room = room;
            Status = status;
        }

        public Time_Table(string classID, string className, string subject, int slot)
        {
            ClassID = classID;
            ClassName = className;
            Subject = subject;
            Slot = slot;
        }
    }
}