package com.sample.demo.tablayout.unit

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.ParseException
import java.util.*

class DateUtils {

    @RequiresApi(Build.VERSION_CODES.N)
    fun get7week(): List<String>? {
        var week = ""
        val weeksList: MutableList<String> = ArrayList()
        val dateList: List<String> = get7date()
        for (s in dateList) {
            if (s == StringData()) {
//                week = "今天"
                week = getWeek(s)
            } else {
                week = getWeek(s)
            }
            weeksList.add(week)
        }
        return weeksList
    }

    fun get7date(): List<String> {
        val dates: MutableList<String> = ArrayList()
        val c = Calendar.getInstance()
        c.timeZone = TimeZone.getTimeZone("GMT+8:00")
        val sim = java.text.SimpleDateFormat(
            "yyyy-MM-dd"
        )
        var date = sim.format(c.time)
        dates.add(date)
        for (i in 0..19) {
            c.add(Calendar.DAY_OF_MONTH, 1)
            date = sim.format(c.time)
            dates.add(date)
        }
        return dates
    }

    fun StringData(): String? {
        val c = Calendar.getInstance()
        c.timeZone = TimeZone.getTimeZone("GMT+8:00")
        val mYear = java.lang.String.valueOf(c[Calendar.YEAR]) // 獲取當前年份
        val mMonth = java.lang.String.valueOf(c[Calendar.MONTH] + 1) // 獲取當前月份
        var mDay = java.lang.String.valueOf(c[Calendar.DAY_OF_MONTH]) // 獲取當前月份的日期號碼
        if (mDay.toInt() > MaxDayFromDay_OF_MONTH(mYear.toInt(), mMonth.toInt())) {
            mDay = java.lang.String.valueOf(MaxDayFromDay_OF_MONTH(mYear.toInt(), mMonth.toInt()))
        }
        return mYear.toString() + "-" + (if (mMonth.length === 1) "0$mMonth" else mMonth) + "-" + if (mDay.length === 1) "0$mDay" else mDay
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getWeek(time: String?): String {
        var Week = ""
        val format = SimpleDateFormat("yyyy-MM-dd")
        val c = Calendar.getInstance()
        var datetext = ""
        try {
            c.time = format.parse(time)
            datetext = SimpleDateFormat("MM/dd ").format(c.time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        if (c[Calendar.DAY_OF_WEEK] === 1) {
            Week += datetext + " (Sunday)"
        }
        if (c[Calendar.DAY_OF_WEEK] === 2) {
            Week += datetext + " (Monday)"
        }
        if (c[Calendar.DAY_OF_WEEK] === 3) {
            Week += datetext + " (Tuesday)"
        }
        if (c[Calendar.DAY_OF_WEEK] === 4) {
            Week += datetext + " (Wednesday)"
        }
        if (c[Calendar.DAY_OF_WEEK] === 5) {
            Week += datetext + " (Thursday)"
        }
        if (c[Calendar.DAY_OF_WEEK] === 6) {
            Week += datetext + " (Friday)"
        }
        if (c[Calendar.DAY_OF_WEEK] === 7) {
            Week += datetext + " (Saturday)"
        }
        return Week
    }

    fun MaxDayFromDay_OF_MONTH(year: Int, month: Int): Int {
        val time = Calendar.getInstance()
        time.clear()
        time[Calendar.YEAR] = year
        time[Calendar.MONTH] = month - 1 //注意,Calendar物件預設一月為0
        return time.getActualMaximum(Calendar.DAY_OF_MONTH) //本月份的天數
    }
}