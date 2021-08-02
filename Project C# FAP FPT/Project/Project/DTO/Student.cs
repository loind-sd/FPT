using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace Project.DTO
{
    public class Student
    {

        public string ID { get; set; }

        public string Name { get; set; }

        public DateTime Dob { get; set; }
        public bool Gender { get; set; }
        public string Address { get; set; }

        public byte[] Image { get; set; }


        public Student(string iD, string name, DateTime dob, bool gender, string address)
        {
            ID = iD;
            Name = name;
            Dob = dob;
            Gender = gender;
            Address = address;
        }

        public Student(string iD, string name)
        {
            ID = iD;
            Name = name;
        }

        public Student(string iD, string name, byte[] image) : this(iD, name)
        {
            Image = image;
        }
    }

    
}