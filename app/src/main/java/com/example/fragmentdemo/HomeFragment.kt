package com.example.fragmentdemo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentdemo.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.submit.setOnClickListener{
            val name = binding.inputLayoutOne.editText?.text.toString()
            val track = binding.inputLayoutTwo.editText?.text.toString()
            val predictions = when(binding.radioGroup.checkedRadioButtonId) {
                R.id.option_one -> "League Title"
                R.id.option_two -> "Promotion"
                R.id.option_three -> "Remain in Division"
                else -> "Relegation"
            }

            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("track", track)
            bundle.putString("predictions",predictions)
            navCon.navigate(R.id.action_homeFragment_to_submissionFragment, bundle)

        }

        val inputOne = binding.inputTextOne
        val inputTwo = binding.inputTextTwo
        val actionButton = binding.submit

        inputOne.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                inputTwo.isEnabled = p0.toString().trim { it <= ' ' }.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        inputTwo.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                actionButton.isEnabled = p0.toString().trim { it <= ' ' }.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })


    }

}