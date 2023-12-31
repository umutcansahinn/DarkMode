package com.umutcansahin.setdarkmodewithbutton.ui.notifications

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umutcansahin.setdarkmodewithbutton.databinding.FragmentNotificationsBinding
import com.umutcansahin.setdarkmodewithbutton.manager.SharedManager
import com.umutcansahin.setdarkmodewithbutton.manager.ThemeManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var themeManager: ThemeManager

    @Inject
    lateinit var sharedManager: SharedManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeUiMode()
        setSwitchWithUiMode()
    }

    private fun changeUiMode() {
        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            themeManager.setUiTheme(isChecked.not())
            saveDarkModeEnabled(isChecked.not())
        }
    }

    private fun setSwitchWithUiMode() {
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {
                binding.switchDarkMode.isChecked = false
            }

            Configuration.UI_MODE_NIGHT_YES -> {
                binding.switchDarkMode.isChecked = true
            }
        }
    }

    fun saveDarkModeEnabled(isDarkModeEnabled: Boolean) {
        sharedManager.saveDarkModeEnabled(isDarkModeEnabled)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}