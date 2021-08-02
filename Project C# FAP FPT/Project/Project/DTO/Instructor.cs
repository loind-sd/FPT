using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Project.DTO
{
    public class Instructor
    {
        public string Id { get; set; }
        public string Name { get; set; }

        public Instructor(string id, string name)
        {
            Id = id;
            Name = name;
        }
    }
}