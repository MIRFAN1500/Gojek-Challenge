package com.binar.gojekchallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.binar.gojekchallenge.databinding.FragmentHomeBinding
import com.binar.gojekchallenge.model.Menu
import com.binar.gojekchallenge.utility.toast

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val gridAdapter = MenuAdapter(
            onItemClick = {
                context?.toast(it.name)
            }
        )

        gridAdapter.setData(getListMenu())
        with(binding) {
            listMenu.adapter = gridAdapter
            listMenu.numColumns = 4
            listMenu.verticalSpacing = 60
            listMenu.stretchMode = GridView.STRETCH_COLUMN_WIDTH
        }

        return binding.root
    }
    private fun getListMenu(): List<Menu> {
        return listOf(
            Menu(R.drawable.icon_go_goride, resources.getString(R.string.goride_gridview)),
            Menu(R.drawable.icon_go_gocar, resources.getString(R.string.gocar_gridview)),
            Menu(R.drawable.icon_go_gofood, resources.getString(R.string.gofood_gridview)),
            Menu(R.drawable.icon_go_gosend, resources.getString(R.string.gosend_gridview)),
            Menu(R.drawable.icon_go_gomart, resources.getString(R.string.gomart_gridview)),
            Menu(R.drawable.icon_go_gopulsa, resources.getString(R.string.gopulsa_gridview)),
            Menu(R.drawable.icon_go_paylater, resources.getString(R.string.gopaylater_gridview)),
            Menu(R.drawable.icon_go_more, resources.getString(R.string.more_gridview)),
        )
    }


}