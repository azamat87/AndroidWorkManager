package kz.azamat.androidworkmanager.input_output_wm

import androidx.work.Data
import androidx.work.InputMerger

class MyMerger : InputMerger() {

    override fun merge(inputs: MutableList<Data>): Data {
        val output = Data.Builder()
        val mergedValues: MutableMap<String, Any> = HashMap()

        for (input in inputs) {
            mergedValues.putAll(input.keyValueMap)
        }

        output.putAll(mergedValues)
        output.putInt("input_data_count", inputs.size - 1)
        return output.build()
    }

}