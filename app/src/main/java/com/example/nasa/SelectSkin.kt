import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.nasa.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SelectSkin : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var photoImageView: ImageView
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private val photoList = listOf(
        R.drawable.astronot1,
        R.drawable.astronot2,

    )
    private var currentPhotoIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_select_skin, container, false)

        photoImageView = view.findViewById(R.id.skinImg)
        prevButton = view.findViewById(R.id.prevBtn)
        nextButton = view.findViewById(R.id.nextBtn)

        // İlk fotoğrafı göster
        photoImageView.setImageResource(photoList[currentPhotoIndex])

        // Önceki buton tıklama işlevi
        prevButton.setOnClickListener {
            showPreviousPhoto()
        }

        // Sonraki buton tıklama işlevi
        nextButton.setOnClickListener {
            showNextPhoto()
        }

        return view
    }

    private fun showPreviousPhoto() {
        if (currentPhotoIndex > 0) {
            currentPhotoIndex--
            photoImageView.setImageResource(photoList[currentPhotoIndex])
        }
    }

    private fun showNextPhoto() {
        if (currentPhotoIndex < photoList.size - 1) {
            currentPhotoIndex++
            photoImageView.setImageResource(photoList[currentPhotoIndex])
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectSkin().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
