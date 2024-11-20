package com.android.developer.prof.reda.chatgptapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.android.developer.prof.reda.chatgptapp.R
import com.android.developer.prof.reda.chatgptapp.databinding.FragmentRobotListScreenBinding

class RobotListScreenFragment : Fragment() {

    private lateinit var binding: FragmentRobotListScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_robot_list_screen,
            container,
            false
        )

        binding.moveBtn.setOnClickListener {
            findNavController().navigate(RobotListScreenFragmentDirections.actionRobotListScreenFragmentToChatScreenFragment())
        }

        return binding.root
    }

}