package com.example.cinemahe.utils;

public class SeatGenerator
{
    public static void main(String[] args)
    {
        for (int i = 1; i < 4; i++)
        {
            for (int j = 1; j < 6; j++)
            {
                for (int k = 1; k < 7; k++)
                {
                    System.out.println("INSERT INTO cahe_seat (seat_number, `row_number`, room_id) VALUES (" + k + ", " + j + ", " + i + ");");
                }
            }
        }
    }
}
