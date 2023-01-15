from PyQt6.QtWidgets import QMainWindow, QApplication, QPushButton, QFileDialog
import sys

from astropy.io import fits
import matplotlib.pyplot as plt
from astropy.utils.data import get_pkg_data_filename
import numpy as np
import cv2 as cv


from os import walk

class Main(QMainWindow):
    def __init__(self):
        super().__init__()
        # INTERFACE 
        btn = QPushButton(self)
        btn.setText("Open file dialog")
        btn.clicked.connect(lambda: self.open_dialog())
        
        # DONNEES
        # img_1 = get_pkg_data_filename('./fits_tests/mini/mini0.fits')   # ouverture de l'image 1
        # img_2 = get_pkg_data_filename('./fits_tests/mini/mini1.fits')   # ouverture de l'image 2

        # image_data1 = fits.getdata(img_1, ext=0)    # data de l'image 1
        # image_data2 = fits.getdata(img_2, ext=0)    # data de l'image 2

        # img_1 = np.array_split(image_data1,1)   # transformation des liste de ce format : [ n1  n2  n3 ... ] en array. (beaucoup plus simples)
        # img_2 = np.array_split(image_data2,1)   # transformation des liste de ce format : [ n1  n2  n3 ... ] en array. (beaucoup plus simples)

    def open_dialog(self):
        fname = QFileDialog.getExistingDirectory(None, 'Open working directory', "Selectionner le dossier")
        listeFichiers = []
        for (repertoire, sousRepertoires, fichiers) in walk(fname):
            listeFichiers.extend(fichiers)
        listeFichiersData = []
        for index in range(len(listeFichiers)):
            listeFichiersData.append((np.array_split(fits.getdata(get_pkg_data_filename(fname+"/"+listeFichiers[index]), ext=0),1)))

        threshold = 3
        for i in range(len(listeFichiersData)):
            for j in range(len(listeFichiersData[i])):
                z = (listeFichiersData[i][j]-np.mean(listeFichiersData[i]))/np.std(listeFichiersData[i])
                if (z > threshold).any():
                    listeFichiersData[i][j] = 35000

        self.moyenne(listeFichiersData)
        self.median(listeFichiersData)

    def moyenne(self, liste_fichier):
        Liste = np.mean(liste_fichier, axis=0)
        for liste in Liste:
            pass
        plt.imshow(liste, cmap="gray")
        plt.show()

    def median(self, liste_fichier):
        Liste = np.median(liste_fichier, axis=0)
        for liste in Liste:
            pass
        plt.imshow(liste, cmap="gray")
        plt.show()



if __name__ == "__main__":
    app = QApplication(sys.argv)
    main_gui = Main()
    main_gui.show()
    sys.exit(app.exec())