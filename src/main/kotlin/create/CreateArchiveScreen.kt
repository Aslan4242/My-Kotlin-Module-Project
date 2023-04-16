package create

import archiveList
import scanner

/**
 * Класс для описания экрана создания архива
 */
class CreateArchiveScreen : CreateScreen() {

    /**
     * Создает новый архив. Архив добавляется в начало списка, т.е. более новые архивы отображаются первыми
     */
    override fun create(index: Int) {
        println("Вы находитесь на экране создания архива.\nВведите, пожалуйста, имя архива.")
        val archiveName = scanner.nextLine()
        archiveList.add(index, archiveName to arrayListOf())
        println("Архив '$archiveName' создан.")
    }
}
