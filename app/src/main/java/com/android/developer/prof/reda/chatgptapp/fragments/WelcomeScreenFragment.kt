package com.android.developer.prof.reda.chatgptapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.android.developer.prof.reda.chatgptapp.R
import com.android.developer.prof.reda.chatgptapp.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome_screen,
            container,
            false
        )

        binding.continueBtn.apply {
            startAnimation(
                AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_in_cut)
            )
        }

        binding.continueBtn.setOnClickListener {
            findNavController().navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToRobotListScreenFragment())
        }


        return binding.root
    }
}