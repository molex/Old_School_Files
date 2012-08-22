using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Math_Game
{
    class Program
    {
        static void Main(string[] args)
        {
            
            Random generator = new Random();
            Double myDouble = generator.NextDouble();
            Console.WriteLine(myDouble);
            Console.ReadLine();
        }
    }
}
