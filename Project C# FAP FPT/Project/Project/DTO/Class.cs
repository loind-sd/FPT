using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Project.DTO
{
    public class Class
    {
        public string ClassID { get; set; }
        public string ClassName { get; set; }
        public string SubjectCode { get; set; }
        public string SubjectName { get; set; }
        public string Instructor { get; set; }

        public Class(string classID, string className, string subjectCode, string subjectName, string instructor)
        {
            ClassID = classID;
            ClassName = className;
            SubjectCode = subjectCode;
            SubjectName = subjectName;
            Instructor = instructor;
        }

        public Class(string classID, string className)
        {
            ClassID = classID;
            ClassName = className;
        }

        public Class(string classID, string className, string subjectName) : this(classID, className)
        {
            SubjectName = subjectName;
        }
    }
}